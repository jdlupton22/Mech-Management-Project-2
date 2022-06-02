class ContactInfo:

    def __init__(self, id: int, user_id: int, contact: str):
        self.id = id
        self.user_id = user_id
        self.contact = contact,

    def __repr__(self):
        return str({
            'id': self.id,
            'user_id': self.user_id,
            'contact': self.contact
        })

    def json(self):
        return {
            'Id': self.id,
            'user_id': self.user_id,
            'contact': self.contact
        }

    def __eq__(self, other):
        if not other:
            return False

        if not isinstance(other, ContactInfo):
            return False

        return self.__dict__ == other.__dict__
