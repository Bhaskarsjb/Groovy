node('master') {

git 'https://www.github.com/wardviaene/terraform-course'

sh '''cd jenkins-packer-demo
aws s3 cp s3://terraform-state-bhaskar/terraform/terraform.tfstate terraform.tfstate
aws s3 cp s3://terraform-state-bhaskar/amivar.tf amivar.tf
touch mykey
touch mykey.pub
terraform apply -var APP_INSTANCE_COUNT=1 -target aws_instance.app-instance'''

}
