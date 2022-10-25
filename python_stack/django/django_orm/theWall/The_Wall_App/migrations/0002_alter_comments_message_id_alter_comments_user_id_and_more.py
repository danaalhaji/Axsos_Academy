# Generated by Django 4.1.1 on 2022-10-04 07:14

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('LoginAndRegister_app', '0001_initial'),
        ('The_Wall_App', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='comments',
            name='message_id',
            field=models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, related_name='messageComments', to='The_Wall_App.messages'),
        ),
        migrations.AlterField(
            model_name='comments',
            name='user_id',
            field=models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, related_name='comments', to='LoginAndRegister_app.users'),
        ),
        migrations.AlterField(
            model_name='messages',
            name='user_id',
            field=models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, related_name='messages', to='LoginAndRegister_app.users'),
        ),
        migrations.DeleteModel(
            name='Users',
        ),
    ]