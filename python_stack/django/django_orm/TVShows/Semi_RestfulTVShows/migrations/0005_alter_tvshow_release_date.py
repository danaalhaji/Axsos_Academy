# Generated by Django 4.1.1 on 2022-10-01 13:19

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Semi_RestfulTVShows', '0004_rename_netwoork_tvshow_network'),
    ]

    operations = [
        migrations.AlterField(
            model_name='tvshow',
            name='release_date',
            field=models.DateTimeField(),
        ),
    ]