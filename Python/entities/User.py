class User:

    def __init__(self, u_id: int, username: str, password: str, firstname: str, lastname: str, is_pilot: bool,
                 is_admin: bool):
        self.u_id = u_id
        self.username = username
        self.password = password
        self.firstname = firstname
        self.lastname = lastname
        self.is_pilot = is_pilot
        self.is_admin = is_admin

    def __repr__(self):
        return str({
            'id': self.u_id,
            'username': self.username,
            "Password": self.password,
            'firstname': self.firstname,
            "lastname": self.lastname,
            'is_pilot': self.is_pilot,
            'is_admin': self.is_admin
        })

    def json(self):
        return {
            'id': self.u_id,
            'username': self.username,
            "password": self.password,
            'firstname': self.firstname,
            "lastname": self.lastname,
            'isPilot': self.is_pilot,
            'isAdmin': self.is_admin
        }
