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
	  sbt
	brew link llvm --force

For other platforms: http://www.scala-native.org/en/latest/user/setup.html

    sbt run
  
Supporting info:

https://parquet.apache.org/documentation/latest/

https://github.com/twitter/scrooge

https://github.com/apache/parquet-cpp