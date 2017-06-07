Run docker

    docker run -v $PWD:/p -it scalawilliam/scala-native-sbt

Inside the docker:    

    cp /p
    sbt run

or

    sbt compile
    ./target/scala-2.11/p-out

Supporting info:

https://parquet.apache.org/documentation/latest/

https://github.com/twitter/scrooge
