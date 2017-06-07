Prerequisities (Mac OSX):

    xcode-select --install &> /dev/null || :
	brew install \
	  bdw-gc \
	  gmp \
	  libevent \
	  libxml2 \
	  libyaml \
	  re2 \
	  llvm \
	  sbt \
	  boost
	brew link llvm --force

For other platforms: http://www.scala-native.org/en/latest/user/setup.html

    sbt run

## Supporting info:

### Specification:

https://parquet.apache.org/documentation/latest/

### Thrift 2 Scala code generator:

https://github.com/twitter/scrooge (info: unable to publish from source)

### Apache CPP reference implementation:

https://github.com/apache/parquet-cpp

### Vanilla Scala JVM implementation reference:

https://github.com/jmd1011/parquet-readers

### Vanilla Go implementation of Apache CPP Parquet:

https://github.com/zenixls2/goparquet