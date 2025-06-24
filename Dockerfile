FROM ubuntu:latest
LABEL authors="afcoe"

ENTRYPOINT ["top", "-b"]