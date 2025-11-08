from flask import Flask, render_template, request
import requests

app = Flask(__name__)

@app.route("/", methods=["GET", "POST"])
def home():
    result = None
    error = None

    if request.method == "POST":
        try:
            todo_id = int(request.form["todo_id"])
            if 1 <= todo_id <= 200:
                response = requests.get(f"https://jsonplaceholder.typicode.com/todos/{todo_id}")
                if response.status_code == 200:
                    result = response.json()["title"]
                else:
                    error = "API Error: Unable to fetch data."
            else:
                error = "Error: Number must be between 1 and 200."
        except ValueError:
            error = "Error: Please enter a valid number."

    return render_template("index.html", result=result, error=error)

if __name__ == "__main__":
    app.run(debug=True)
