from flask import Flask
from flask import render_template
from flask import request, redirect, url_for,flash
from werkzeug.utils import secure_filename
import os
app = Flask(__name__)

APP_ROOT = os.path.dirname(os.path.abspath(__file__))
UPLOAD_FOLD = '/Users/Jiahui/Desktop/AppVideo'
UPLOAD_FOLDER = os.path.join(APP_ROOT, UPLOAD_FOLD)



@app.route('/', methods=['GET', 'POST'])
def upload_file():
    if request.method == 'POST':
        if 'file' not in request.files:
            return "No file part"
        file = request.files['file']

        if file.filename == '':
            return 'No selected file'
        if file:
            filename = secure_filename(file.filename)
            file.save(os.path.join("/Users/Jiahui/Desktop/AppVideo", filename))
            return "File Uploaded"
    return "Called"

if __name__ == "__main__":
    app.run(host="0.0.0.0")
