FROM tomcat:9-jre11
RUN rm -rf /usr/local/tomcat/webapps/*
RUN mv /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps
COPY ./tomcat/tomcat-users.xml  /usr/local/tomcat/conf
COPY ./tomcat/manager/context.xml  /usr/local/tomcat/webapps/manager/META-INF
COPY ./target/handbook.war  /usr/local/tomcat/webapps
#ENV JPDA_ADDRESS=0.0.0.0:8000
#ENV JPDA_TRANSPORT=dt_socket
EXPOSE 8080
EXPOSE 8000
CMD ["catalina.sh", "jpda", "run"]
#CMD ["catalina.sh", "run"]

#------use network-----#
#docker run --network handbook --name handbook -p 8080:8080 handbook
#docker run --network handbook -v D:\Git\handbook\tomcat\logs:/usr/local/tomcat/logs --name handbook -p 8080:8080 handbook
#docker run --network handbook -v D:\Git\handbook\tomcat\logs:/usr/local/tomcat/logs -v D:\Git\handbook\target\handbook:/usr/local/tomcat/webapps/handbook --name handbook -p 8080:8080 handbook
#docker run --network handbook -v D:\Git\handbook\tomcat\logs:/usr/local/tomcat/logs -v D:\Git\handbook\target\handbook.war:/usr/local/tomcat/webapps/handbook.war  --name handbook -p 8080:8080 handbook
