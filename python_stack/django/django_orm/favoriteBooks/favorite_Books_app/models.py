from django.db import models
from LoginAndRegisterAPP.models import *

class BookManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['TitleInput']) == 0:
            errors['TitleInput'] = "The title is required"
        if len(postData['DescInput']) <9:
            errors['DescInput'] = "The description  Should be atleast 8 characters"

class Book(models.Model):
    title = models.CharField(max_length = 255)
    describtion = models.CharField(max_length=255)
    uploaded_by = models.ForeignKey(Users, related_name = "books_uploaded", on_delete = models.DO_NOTHING)
    Users_who_likes =  models.ManyToManyField(Users , related_name = "liked_books")
    created_at = models.DateTimeField (auto_now_add = True)
    updated_at = models.DateTimeField (auto_now = True)

# Create your models here.
