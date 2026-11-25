# Synthetic IaC test data (intentionally insecure). Not real infrastructure.
terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = "us-east-1"
}

# Open firewall rule: SSH and RDP open to the whole internet
resource "aws_security_group" "open_admin_ports" {
  name        = "open-admin-ports"
  description = "Synthetic open security group"
  vpc_id      = "vpc-0123456789abcdef0"

  ingress {
    description = "SSH from anywhere"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    description = "RDP from anywhere"
    from_port   = 3389
    to_port     = 3389
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# Public storage: bucket with a public-read ACL, no encryption, no versioning, no logging
resource "aws_s3_bucket" "public_data" {
  bucket = "synthetic-public-data-bucket"
}

resource "aws_s3_bucket_acl" "public_data_acl" {
  bucket = aws_s3_bucket.public_data.id
  acl    = "public-read"
}

# Unencrypted storage
resource "aws_ebs_volume" "unencrypted_volume" {
  availability_zone = "us-east-1a"
  size              = 10
  encrypted         = false
}

resource "aws_db_instance" "unencrypted_db" {
  identifier          = "synthetic-db"
  allocated_storage   = 20
  engine              = "mysql"
  instance_class      = "db.t3.micro"
  username            = "admin"
  storage_encrypted   = false
  publicly_accessible = true
  skip_final_snapshot = true
}
