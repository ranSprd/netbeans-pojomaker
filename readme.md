Netbeans PojoMaker Plugin
=========================

# Introduction

This plugin is a small integrated interface of [jsonschema2pojo](https://www.jsonschema2pojo.org/) which generates simple 
Java classes from Json schema or much simpler raw Json snippets. 

After installation of the nbm file you can find the plugin in action in the context menu of each project source tree node (_New from json..._)

![Where can I find the Plugin](./assets/PojoMakerAction.png)


# Changelog

- 0.4.0
    - set a class name prefix
    - type of source (schema, json, yaml)
- 0.3.3 version release in central maven repository and available in Netbeans Plugins
- 0.1.0 first version

# Developement

## release

Follow the instruction given at [sonatype](https://central.sonatype.org/publish/publish-maven/) 
and prepare your gpg key. For a release type

    mvn clean deploy
