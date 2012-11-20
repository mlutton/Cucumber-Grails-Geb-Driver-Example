package steps

import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver

import static cucumber.runtime.groovy.Hooks.After
import static cucumber.runtime.groovy.Hooks.Before

this.metaClass.mixin (cucumber.runtime.groovy.EN)

Browser browser

Before() {
    browser = new Browser(driver: new FirefoxDriver())
}
Given(~'^I am on the Amazon homepage$') { ->
    browser.go("http://www.amazon.com")
}

When(~'^I search for "clean code"$') { ->
    def searchBox = browser.page.$("input#twotabsearchtextbox")
    searchBox.value("clean code")
    browser.page.$(".nav-submit-input").click()
}

Then(~'^I should see results with the name "clean code"$') { ->
    String pageText = browser.page.text().toString()
    assert pageText.contains("clean code")
}

Then(~'^I should see products other users are looking at$') { ->
    String pageText = browser.page.text().toString()
    assert pageText.contains('What Other Customers Are Looking At Right Now')
}

After() {
    browser.quit()
}