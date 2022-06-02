from flask import request, jsonify
from entities.User import User
from exceptions.resource_not_found import ResourceNotFound
from repos.impl.User_repo import UserRepo
from services.User_service import UserServices

ur = UserRepo()
us = UserServices(ur)


def route(app):
    @app.route("/user", methods=['GET'])
    def get_users():
        return jsonify([user.json() for user in us.get_users()])

    @app.route("/user/<u_id>", methods=['GET'])
    def get_user(u_id):
        try:
            return us.get_user(int(u_id)).json(), 200
        except ValueError as e:
            return "Not a valid ID", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/user", methods=["POST"])
    def post_user():
        body = request.json

        user = User(u_id=body["u_id"], username=body["username"], password=body["password"],
                    firstname=body["firstname"], lastname=body["lastname"], is_pilot=body[bool], is_admin=body[bool])
        user = us.create_user(user)

        return user.json()

    @app.route("/user/<u_id>", methods=["PUT"])
    def put_user(u_id):
        body = request.json
        user = User(u_id=u_id, username=body["username"], password=body["password"], firstname=body["firstname"],
                    lastname=body["lastname"], is_pilot=body["isPilot"], is_admin=body["isAdmin"])
        user = us.update_user(user)

        return user.json()

    @app.route("/user/<u_id>", methods=['DELETE'])
    def delete_user(u_id):
        us.delete_user(u_id)
        return '', 204
