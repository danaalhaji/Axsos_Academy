from django.db import models
import re
from time import gmtime, strftime, time
# create the validation manager for our mTVShow model
class TVShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        DATE_REGEX = re.compile(r'^20[0-2][0-9]-((0[1-9])|(1[0-2]))-(0[1-9]|[1-2][0-9]|3[0-1])$')
        if not DATE_REGEX.match(postData['releaseddate'] ):
            errors['releaseddate'] = "Invalid Date"
        if len(postData['addTitleText'])<2:
            errors['addTitleText'] = "The Title Should be atleast 5 characters"
        if len(postData['Description'])<10:
            errors['Description'] = "The description Should be atleast 10 characters"
        if len(postData['addNetworkText']) < 3 :
            errors['addNetworkText'] = "The title Should be atleast 3 characters"
        return errors
# write the model and it's fields
class TVShow(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    release_date = models.DateTimeField()
    desc = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now = True )
    objects = TVShowManager()
# Create your models here.
