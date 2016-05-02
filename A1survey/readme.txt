Nikita Sanjay Gulabani
G00912741

/*Below are the links to the home page and survey html*/

S3 home.html url- http://ec2-52-90-19-110.compute-1.amazonaws.com/A1survey/home.html
EC2 survey.html url - http://ec2-52-90-19-110.compute-1.amazonaws.com/A1survey/survey.html


/*To create bucket in S3*/
1.Sign in to the AWS Management Console and open the Amazon S3 console at https://console.aws.amazon.com/s3/.

2.Create a bucket.

3.For bucket naming guidelines, see Bucket Restrictions and Limitations. 

4.Open the bucket Properties panel, click Static Website Hosting, and do the following:

5.Select the Enable website hosting.

6.In the Index Document box, add the name of your index document. This name is typically index.html.

7.Click Save to save the website configuration.

8.Note down the Endpoint.

9.Select the Bucket and in Actions Make it public.

10.Open the Endpoint on the Browser.


/*For EC2 installation, and deploment of .war file */

1. Go to https://aws.amazon.com and open an account. You can use it
for free for a year. But you have to enter credit card information
though they don't charge you.
2. Go to EC2 Virtual Servers in the cloud.
3. Click on "Launch Instance"
4. Click on "AWS Marketplace", it is present on the left side of the
page.
5. In the search tab, type "Tomcat Bitnami". You will get a list of
images. Select the one appropriate for you. Remember to choose the
free tier eligible. It will contain ready to use versions of Apache,
Tomcat and MySQL etc, which will be used in our assignments.
6. After selecting the particular image scroll down to the end of page
and click "Review and Launch".
7. Then click "Launch". Once you click launch a window will pop up and
ask for "Select an existing key pair or create a new key pair". Choose
"Create a new key pair". Enter the name of your choice for the key
pair. Then download and save the key pair without fail. Remember this
is the only time when you can save the key pair to your computer. You
will need this while connecting. Finally click on "Launch Instance"
8. Then on the next appeared page scroll down and click "View
Instances". It will take some time to initialize and to start running.
Note: Once the instance is launched you can go to "Actions", click on
"Instance State" and then choose to Stop, Start, Reboot and Terminate
options for your instance.
10. To connect to your instance. Select the instance and then click on
"Connect"
11. Choose "I would like to connect with A standalone SSH client"
(Your Linux computer most likely includes an SSH client by default.
You can check for an SSH client by typing ssh at the command line. If
your computer doesn't recognize the command, the OpenSSH project
provides a free implementation of the full suite of SSH tools. For
more information, see http://www.openssh.org.)
11. Open the SSH client.
12. Locate your private key pair (key pair you downloaded and saved).
Change directories to the location of the private key pair file that
you created when you launched the instance.
13. Use the chmod command to make sure your private key file isn't
publicly viewable. For example, if the name of your private key file
is my-key-pair.pem, you would use the following command
 chmod 400 my-key-pair.pem
14. Use the following ssh command to connect to the instance. You'll
specify the private key (.pem) file and user_name@public_dns_name. For
Amazon Linux, the user name is ec2-user. For RHEL5, the user name is
either root or ec2-user. For Ubuntu, the user name is ubuntu. For
Fedora, the user name is either fedora or ec2-user. For SUSE Linux,
the user name is either root or ec2-user. Otherwise, if ec2-user and
root don't work, check with your AMI provider.
 ssh -i my-key-pair.pem ec2-user@ec2-198-51-100-
1.compute1.amazonaws.com
Note: You will get the example of your ssh command in the "Connect to
your Instance" window when you clicked "Connect". You can copy & paste 
the same command. As it will have your credentials (key pair name,
user name and IP address).
15. You'll see a response like the following.
The authenticity of host 'ec2-198-51-100-1.compute-1.amazonaws.com
(10.254.142.33)' can't be established. RSA key fingerprint is
1f:51:ae:28:bf:89:e9:d8:1f:25:5d:37:2d:7d:b8:ca:9f:f5:f1:6f.
Are you sure you want to continue connecting (yes/no)?
16. Enter yes
You'll see a response like the following.
Warning: Permanently added 'ec2-198-51-100-1.compute-1.amazonaws.com'
(RSA) to the list of known hosts.
17. For transferring Files to Linux Instances from Linux Using SCP,
use following command. Most Linux, Unix, and Apple computers include
an SCP client by default. If yours doesn't, the OpenSSH project
provides a free implementation of the full suite of SSH tools,
including an SCP client. For more information, go to
http://www.openssh.org.
 scp -i /path/my-key-pair.pem ~/path of your war file ec2user@ec2-
198-51-100-1.compute-1.amazonaws.com:~
This will copy your war file in the ec2-user home directory. To deploy
your applications on EC2 you are required to keep your war file in
apache-tomcat's webapps folder. Locate this folder and keep the file
there.
19. You'll see a response like the following.
The authenticity of host 'ec2-198-51-100-1.compute-1.amazonaws.com
(10.254.142.33)' can't be established.
RSA key fingerprint is
1f:51:ae:28:bf:89:e9:d8:1f:25:5d:37:2d:7d:b8:ca:9f:f5:f1:6f.
Are you sure you want to continue connecting (yes/no)?
20. Enter yes
21. You'll see a response like the following.
Warning: Permanently added 'ec2-198-51-100-1.compute-1.amazonaws.com'
(RSA) to the list of known hosts.
Sending file modes: C0644 20 SampleFile.txt
Sink: C0644 20 SampleFile.txt
SampleFile.txt 100% 20 0.0KB/s 00:00
Note : If you receive a "bash: scp: command not found" error, you must
first install scp on your Linux instance. For some operating systems, 
this is located in the openssh-clients package. For Amazon Linux
variants, such as the Amazon ECS-optimized AMI, use the following
command to install scp.
 [ec2-user ~]$ sudo yum install -y openssh-clients
22. In the browser copy paste the Public DNS path of your instance.
You will get the home page of Tomcat Bitnami.
23. Now just add the name of your homework folder to the path and you
can see your homework homepage.
Example: http://ec2-52-89-94-175.us-west-2.compute.amazonaws.com/HW1/
24. Stop the instance once you are done and logout from the AWS Amazon
account.
