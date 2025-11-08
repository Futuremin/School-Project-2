import requests
import sys

def check_website_status(url):
    try:
        response = requests.get(url)
        print(f"Status Code: {response.status_code} - {response.reason}")
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python check_status.py <URL>")
    else:
        check_website_status(sys.argv[1])
