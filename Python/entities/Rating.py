class Rating:

    def __init__(self, r_id: int, user_id: int, mech_id: int, stars: int, review: str):
        self.r_id = r_id
        self.user_id = user_id
        self.mech_id = mech_id
        self.stars = stars
        self.review = review

    def __repr__(self):
        return str({
            'id': self.r_id,
            'user_id': self.user_id,
            "mech_id": self.mech_id,
            'stars': self.stars,
            'review': self.review
        })

    def json(self):
        return {
            'Id': self.r_id,
            'UserId': self.user_id,
            "MechId": self.mech_id,
            'Stars': self.stars,
            'Review': self.review
        }