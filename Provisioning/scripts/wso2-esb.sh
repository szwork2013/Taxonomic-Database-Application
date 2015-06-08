#!/usr/bin/env bash

cd /opt

#Install WSO2 ESB
wget --user-agent="testuser" --referer="http://connect.wso2.com/wso2/getform/reg/new_product_download" http://dist.wso2.org/products/enterprise-service-bus/4.8.1/wso2esb-4.8.1.zip
unzip wso2esb-4.8.1.zip

sudo cp /vagrant/config/wso2-esb/wso2-esb /etc/init.d/wso2-esb
sudo chmod 755 /etc/init.d/wso2-esb
sudo chkconfig --add wso2-esb

service wso2-esb start
