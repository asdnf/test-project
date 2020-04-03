# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "asdnf/ubuntu1904"
  config.vm.box_check_update = false
  # config.vm.network "forwarded_port", guest: 80, host: 8080
  # config.vm.network "forwarded_port", guest: 80, host: 8080, host_ip: "127.0.0.1"
  # config.vm.network "private_network", ip: "192.168.33.10"
  # config.vm.network "public_network"
  # config.vm.synced_folder "../data", "/vagrant_data"

  config.vm.provider "virtualbox" do |vb|
    vb.memory = 1024
    vb.cpus = 1
  end

  config.vm.provision "shell", name: "init", inline: <<-SHELL
    apt-get update
    apt-get -y upgrade
    apt-get -y install openjdk-8-jdk maven git zip
    echo 2 | update-alternatives --config java
  SHELL

  config.vm.provision "shell", name: "build-mvn", privileged: false, inline: <<-SHELL
    cd /vagrant
    mvn clean install
  SHELL


  # JAR files, so called Java libraries, are basically a zip archives. Java process can handle the jar files
  # "out of the box". When jar file is kicked off, Java unpacks the contents of the archive, looks for the Manifest
  # file, finds there a details of program launch, and finally starts the JVM Virtual Machine for the class files
  # of the jar. The outcome file of this script is tmp/runnable.jar. It can be tested by running
  # java -jar tmp/runnable.jar
  # This kind of a jar file is so called "fat jar" as it contains all ats dependencies in one jar archive file.
  #
  # Task: Given a working script here must be explained.
  # Describe each line of the script: what the command do as an instance, what it does in terms of the script.
  # Find each unfamiliar command or its detail in internet if needed. Form a solution as a
  # git commit in separate branch, forked from this commit.

  config.vm.provision "shell", name: "build-manual", privileged: false, inline: <<-SHELL
    cd /vagrant
    mvn clean
    cd src/main/java/org/test/sample

    javac -cp \
/home/vagrant/.m2/repository/org/springframework/spring-aop/5.2.4.RELEASE/spring-aop-5.2.4.RELEASE.jar\
:/home/vagrant/.m2/repository/org/springframework/spring-beans/5.2.4.RELEASE/spring-beans-5.2.4.RELEASE.jar\
:/home/vagrant/.m2/repository/org/springframework/spring-context/5.2.4.RELEASE/spring-context-5.2.4.RELEASE.jar\
:/home/vagrant/.m2/repository/org/springframework/spring-core/5.2.4.RELEASE/spring-core-5.2.4.RELEASE.jar\
:/home/vagrant/.m2/repository/org/springframework/spring-expression/5.2.4.RELEASE/spring-expression-5.2.4.RELEASE.jar\
:/home/vagrant/.m2/repository/org/springframework/spring-jcl/5.2.4.RELEASE/spring-jcl-5.2.4.RELEASE.jar\
:/home/vagrant/.m2/repository/org/apache/httpcomponents/httpclient/4.3.6/httpclient-4.3.6.jar\
:/home/vagrant/.m2/repository/org/apache/httpcomponents/httpcore/4.3.3/httpcore-4.3.3.jar\
:/home/vagrant/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar\
:/home/vagrant/.m2/repository/commons-codec/commons-codec/1.6/commons-codec-1.6.jar\
 *.java

    cd /vagrant
    mkdir -p tmp
    cd tmp
    mkdir -p org/test/sample
    mv ../src/main/java/org/test/sample/*.class org/test/sample/
    
    mkdir META-INF
    cd META-INF
    
    echo "Main-Class: org.test.sample.Main" > MANIFEST.MF
    echo "Class-Path: META-INF/lib/commons-codec-1.6.jar META-INF/lib/spring-beans-5.2.4.RELEASE.jar \
META-INF/lib/commons-logging-1.1.3.jar META-INF/lib/spring-context-5.2.4.RELEASE.jar META-INF/lib/httpclient-4.3.6.jar \
META-INF/lib/spring-core-5.2.4.RELEASE.jar META-INF/lib/httpcore-4.3.3.jar META-INF/lib/spring-expression-5.2.4.RELEASE.jar \
META-INF/lib/spring-aop-5.2.4.RELEASE.jar META-INF/lib/spring-jcl-5.2.4.RELEASE.jar" >> MANIFEST.MF
    
    mkdir lib
    cd lib

    cp /home/vagrant/.m2/repository/org/springframework/spring-aop/5.2.4.RELEASE/spring-aop-5.2.4.RELEASE.jar .
    cp /home/vagrant/.m2/repository/org/springframework/spring-beans/5.2.4.RELEASE/spring-beans-5.2.4.RELEASE.jar .
    cp /home/vagrant/.m2/repository/org/springframework/spring-context/5.2.4.RELEASE/spring-context-5.2.4.RELEASE.jar .
    cp /home/vagrant/.m2/repository/org/springframework/spring-core/5.2.4.RELEASE/spring-core-5.2.4.RELEASE.jar .
    cp /home/vagrant/.m2/repository/org/springframework/spring-expression/5.2.4.RELEASE/spring-expression-5.2.4.RELEASE.jar .
    cp /home/vagrant/.m2/repository/org/springframework/spring-jcl/5.2.4.RELEASE/spring-jcl-5.2.4.RELEASE.jar .
    cp /home/vagrant/.m2/repository/org/apache/httpcomponents/httpclient/4.3.6/httpclient-4.3.6.jar .
    cp /home/vagrant/.m2/repository/org/apache/httpcomponents/httpcore/4.3.3/httpcore-4.3.3.jar .
    cp /home/vagrant/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar .
    cp /home/vagrant/.m2/repository/commons-codec/commons-codec/1.6/commons-codec-1.6.jar .
    cd ../..

    cp -r ../src/main/resources/* .

    zip -r9 runnable.jar *

  SHELL

end
