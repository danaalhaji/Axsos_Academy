# Generated by Django 4.1.1 on 2022-09-30 14:21

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('books_and_authers', '0002_alter_book_describtion'),
    ]

    operations = [
        migrations.RenameModel(
            old_name='Auther',
            new_name='Author',
        ),
    ]