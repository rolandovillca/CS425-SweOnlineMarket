FROM mysql:8

ARG root_password
ARG database
ARG user
ARG password

RUN echo ${root_password}
RUN echo ${database}
RUN echo ${user}
RUN echo ${password}

ENV MYSQL_ROOT_PASSWORD=${root_password}
ENV MYSQL_DATABASE=${database}
ENV MYSQL_USER=${user}
ENV MYSQL_PASSWORD=${password}

COPY dbscript.sql .

EXPOSE 3306
