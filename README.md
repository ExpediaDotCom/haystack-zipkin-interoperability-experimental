[![Build Status](https://travis-ci.com/ExpediaDotCom/haystack-zipkin-interoperability-experimental.svg?branch=master)](https://travis-ci.com/github/ExpediaDotCom/haystack-zipkin-interoperability-experimental)
[![License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://github.com/ExpediaDotCom/haystack/blob/master/LICENSE)


# haystack-zipkin-interoperability-experimental
Library to convert the three ids, viz trace-id , span-id, parent-span-id in UUID format to 
zipkin B3 format in terms of hex char encodings.

## Disclaimer 
This is an experimental library. If we see it's usage, we will bring it to the mainstream library.


## Building

Since this repo contains haystack-idl as the submodule, so use the following to clone the repo

```git clone git@github.com:ExpediaDotCom/haystack-zipkin-interoperability-experimental.git```

#### Prerequisite: 

* Make sure you have Java 1.8
* Make sure you have maven 3.3.9 or higher


#### Build

For a full build including unit tests, one can run -

```
mvn clean package
```

* Update maven version

* Raise a PR

#### Releasing haystack-commons
* https://github.com/ExpediaDotCom/haystack-zipkin-interoperability-experimental/blob/master/Release.md

