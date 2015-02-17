After getting the project from git set the following properties in pom and run verify goal

    <saucelabs.target.platform>MAC</saucelabs.target.platform>
		<saucelabs.driver.version>31.0</saucelabs.driver.version>
		<saucelabs.url>http://<VALIDUSER>:<VALID_KEY>@ondemand.saucelabs.com:80/wd/hub</saucelabs.url>
		<saucelabs.access.key><VALID_KEY></saucelabs.access.key>
		<saucelabs.user.id><VALID_USER></saucelabs.user.id>
		<webdriver.driver>firefox</webdriver.driver>
		<webdriver.base.url>http://shoestore-manheim.rhcloud.com</webdriver.base.url>
		<maven.test.failure.ignore>true</maven.test.failure.ignore>
