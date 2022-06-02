from flask import jsonify, request
from entities.picture import Picture
from exceptions.resource_not_found import ResourceNotFound
from repos.impl.picture_repo import PictureRepo
from services.picture_service import PictureServices

pr = PictureRepo()
ps = PictureServices(pr)


def route(app):
    @app.route("/picture", methods=['GET'])
    def get_pics():
        return jsonify([user.json() for user in ps.get_pics()])

    @app.route("/picture/<id>", methods=['GET'])
    def get_pic(id):
        try:
            return ps.get_pic(int(id)).json(), 200
        except ValueError as e:
            return "Not a valid ID", 400
        except ResourceNotFound as r:
            return r.message, 404

    @app.route("/picture", methods=["POST"])
    def post_pic():
        body = request.json

        pic = Picture(id=body["id"], file=body["file"], mech_id=body["mech_id"])
        pic = ps.create_pic(pic)

        return pic.json()

    @app.route("/picture/<id>", methods=["PUT"])
    def put_pic(id):
        body = request.json
        pic = Picture(id=id, file=body["file"], mech_id=body["mech_id"])
        pic = ps.update_pic(pic)

        return pic.json()

    @app.route("/picture/<id>", methods=['DELETE'])
    def delete_pic(id):
        ps.delete_pic(id)
        return '', 204
