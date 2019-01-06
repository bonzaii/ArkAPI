# ArkAPI

This is a place holder for an **API** that uses **RCON** to communicate with a server for **ARK: Survival Evolved**

Language of preference is ~~python~~ **Java**, because I was fed up with Python.

**DISCLAIMER**: Please note that this is my first attempt at Python and therefore bugs are expected.

Any tips & help is greatly appreciated.

# Prerequisites

- standard libraries

# Roadmap

Top Priority
---
- [x] Start! LOL
- [x] Establish the way to store basic configuration, like server list etc
- [x] establish connection with the server and issue a test command
- [ ] implement config
- [ ] create persistent connection to a server - 2 threads per server - read & write
- [ ] create multiple persistent connections

Other priority
---
- way to dynamically change configuration of this service (i.e web interface, command line etc)
- way to communicate with the service via some form of REST (light weight JSON requests?)

# Ideas

Ideas that are **NOT** planned for implementation - pure brain dump of things that I ever might consider implementing.
- Stackable build - allow for plugins
- Enable CrossARK Chat for GLOBAL Messages (as a plugin?)
- Reward system to use with [Ark-Servers.net API](https://ark-servers.net/help/api/) (as a plugin?)
- Connection to TeamSpeak3 serer
- Connection to Discord



---

**Useful stuff I learned on various topics (please forgive my ignorance, I am only learning git)**

Git command `git config credential.helper store` makes it cache credentials
