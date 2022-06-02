from data.decorators import data


class Picture:

    def __init__(self, id: int, file: data, mech_id: int):
        self.id = id
        self.file = file
        self.mech_id = mech_id

    def __repr__(self):
        return str({
            'id': self.id,
            'file': self.file,
            'mech_id': self.mech_id
        })

    def json(self):
        return {
            'Id': self.id,
            'File': self.file,
            'MechId': self.mech_id
        }

    def __eq__(self, other):
        if not other:
            return False

        if not isinstance(other, Picture):
            return False

        return self.__dict__ == other.__dict__
