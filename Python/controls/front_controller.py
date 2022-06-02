from controls import home_controller, mech_controller, user_controller, Rating_controller, picture_controller


def route(app):

    home_controller.route(app)
    mech_controller.route(app)
    user_controller.route(app)
    Rating_controller.route(app)
    picture_controller.route(app)
