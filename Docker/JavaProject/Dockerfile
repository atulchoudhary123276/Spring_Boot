FROM openjdk:11
LABEL authors="atulchaudhary"

WORKDIR /usr/src/myapp
COPY . /usr/src/myapp/
RUN javac Test.java

CMD ["java","Test"]