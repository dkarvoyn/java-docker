#!/bin/sh
docker run \
--detach \
--name=mysql-sample \
--env="MYSQL_ROOT_PASSWORD=myrootpassword" \
--env="MYSQL_USER=myuser" \
--env="MYSQL_PASSWORD=mypassword" \
--env="MYSQL_DATABASE=mydb" \
--publish 3306:3306 \
--volume `pwd`/conf.d:/etc/mysql/conf.d \
--volume `pwd`/mysql-data:/var/lib/mysql \
mysql
