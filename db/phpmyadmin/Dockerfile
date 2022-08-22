FROM phpmyadmin/phpmyadmin

ARG DEFAULT_PORT=80
ENV PORT $DEFAULT_PORT
EXPOSE $PORT

#docker build -t phpmyadmin .
#docker run -d --name phpmyadmin -e PMA_ARBITRARY=1 -p 8080:80 phpmyadmin
#docker run -d --name phpmyadmin -e PMA_HOST=172.17.0.2 -e PMA_PORT=3306 -p 9100:80 phpmyadmin
#docker run -d --name phpmyadmin -e PMA_HOST=mysql -e PMA_PORT=3306 -p 9100:80 phpmyadmin