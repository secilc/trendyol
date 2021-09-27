**Starting selenium grid with docker compose**
docker-compose -f docker-compose.yml up
nodes can be scaled with --scale chrome=3
**Starting test run**
mvn clean install
this command takes the browser parameter inside cross_browser.xml

**Starting test run with selected browser**
mvn test -Dbrowser_name=firefox
