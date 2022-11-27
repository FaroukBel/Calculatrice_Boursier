from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.keys import Keys
from time import sleep

username = "2976354"
password = "Farouk123"

def myfunc():
    user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36"
    # options = webdriver.ChromeOptions()
    # options.headless = True
    # options.add_argument(f'user-agent={user_agent}')
    # options.add_argument("--window-size=1920,1080")
    # options.add_argument('--ignore-certificate-errors')
    # options.add_argument('--allow-running-insecure-content')
    # options.add_argument("--disable-extensions")
    # options.add_argument("--proxy-server='direct://'")
    # options.add_argument("--proxy-bypass-list=*")
    # options.add_argument("--start-maximized")
    # options.add_argument('--disable-gpu')
    # options.add_argument('--disable-dev-shm-usage')
    # options.add_argument('--no-sandbox')
    driver = webdriver.Chrome(executable_path="C:\Program Files (x86)\chromedriver.exe")
    driver.get("https://bpbourse.gbp.ma/Pages/Espaceclient.aspx")
    driver.implicitly_wait(10)
    login = driver.find_element(By.NAME, 'submit')
    login.send_keys(Keys.RETURN)
    # passwrd = driver.find_element_by_name("passwrd")
    # passwrd.send_keys("Farouk123")
    # passwrd.send_keys(Keys.RETURN)
    # try:
    #     WebDriverWait(driver, 10).until(
    #         EC.presence_of_element_located((By.XPATH, "//*[@id='conteneur_frame']/form/table/tbody/tr[3]/td/table/tbody/tr[1]/td[2]/input"))
    #     )
    #
    # finally:
    #     driver.quit()

    print(driver.title)

myfunc()