- Project uses maven to manage depencies.
- Test runs again a local setup selenium grid which should be started with command >> 'docker-compose -f docker-compose.yml up'
- Nodes can be scaled with >> '--scale chrome=3'
- To start the test use command 'mvn clean install' .This command takes the browser parameter inside cross_browser.xml which is used by testng.
- Default browser is set as local chrome and works in mac
- Starting test run with selected remote browser against selenium grid >> 'mvn test -Dbrowser_name=chrome'

