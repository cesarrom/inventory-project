FROM openjdk:8u222-jdk
RUN mkdir inventory
ADD . /inventory
WORKDIR /inventory
RUN sed -i 's/\r$//' init.sh
CMD [ "/bin/bash","init.sh" ]