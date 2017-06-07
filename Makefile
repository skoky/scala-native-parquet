.PHONY: all setup

setup:
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

all:
	@echo "nothing to do"