# Generated by Django 4.1.1 on 2022-09-28 09:32

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Semi_RestfulTVShows', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='tvshow',
            name='release_date',
            field=models.DateTimeField(default='1/1/2000'),
        ),
    ]
