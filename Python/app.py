import logging
from flask import Flask
from flask_cors import CORS
import controls.front_controller as fc


logging.basicConfig(filename="records.log", level=logging.DEBUG, format=f"%(asctime)s %(levelname)s %(message)s")

app = Flask(__name__)
cors = CORS(app)

fc.route(app)

if __name__ == '__main__':
    app.run(port=5000)
