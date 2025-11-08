import tkinter as tk
from tkinter import messagebox

def submit_form():
    name = name_var.get()
    email = email_var.get()
    phone = phone_var.get()
    gender = gender_var.get()
    course = course_var.get()
    agree = agree_var.get()

    if not all([name, email, phone, gender, course]) or not agree:
        messagebox.showerror("Error", "Please fill all fields and agree to the terms.")
    else:
        messagebox.showinfo("Success", f"Registered!\nName: {name}\nEmail: {email}\nPhone: {phone}\nGender: {gender}\nCourse: {course}")

app = tk.Tk()
app.title("Registration Form")

name_var = tk.StringVar()
email_var = tk.StringVar()
phone_var = tk.StringVar()
gender_var = tk.StringVar()
course_var = tk.StringVar()
agree_var = tk.IntVar()

tk.Label(app, text="Full Name").pack()
tk.Entry(app, textvariable=name_var).pack()

tk.Label(app, text="Email").pack()
tk.Entry(app, textvariable=email_var).pack()

tk.Label(app, text="Phone Number").pack()
tk.Entry(app, textvariable=phone_var).pack()

tk.Label(app, text="Gender").pack()
tk.Radiobutton(app, text="Male", variable=gender_var, value="Male").pack()
tk.Radiobutton(app, text="Female", variable=gender_var, value="Female").pack()
tk.Radiobutton(app, text="Other", variable=gender_var, value="Other").pack()

tk.Label(app, text="Select Course").pack()
tk.OptionMenu(app, course_var, "Python", "Java", "C++").pack()

tk.Checkbutton(app, text="Agree to Terms", variable=agree_var).pack()
tk.Button(app, text="Submit", command=submit_form).pack()

app.mainloop()
