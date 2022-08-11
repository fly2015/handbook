FROM tomcat:9-jre11
RUN rm -rf /usr/local/tomcat/webapps/*
RUN mv /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps
COPY ./tomcat/tomcat-users.xml  /usr/local/tomcat/conf
COPY ./tomcat/context.xml  /usr/local/tomcat/webapps/manager/META-INF
ENV JPDA_ADDRESS=0.0.0.0:8000
ENV JPDA_TRANSPORT=dt_socket
CMD ["catalina.sh", "jpda", "run"]
#CMD ["catalina.sh", "run"]