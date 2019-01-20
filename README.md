# URLShortener

This is an API for creating a short alias to a longer page link and for discover the longer page through the short alias. For example, http://dvb.com/1q2w3e for https://spring.io/projects/spring-boot.

Use maven to run ( $ mvn spring-boot:run ) and http://localhost:8080/ in your browser.

Docker:

As root you cas use to build an image: docker build -t dvb-urlshortener . 
  
and to run the container: docker run -it -p 8080:8080 --name dvb-urlshortener-container dvb-urlshortener
