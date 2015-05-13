from django.db import models
from jpype import *

from django.utils import timezone

class Post(models.Model):
    author = models.ForeignKey('auth.User')
    title = models.CharField(max_length=200)
    text=models.TextField()

    startJVM(getDefaultsJVMPath(),"-ea")
    java.lang.System.out.println("hello world")
    shutdownJVM()

    created_date= models.DateTimeField(blank=True, null=True)
    publish_date= models.DateTimeField(blank=True, null=True)

    def publish(self):
        self.publish_date=timezone.now()
        self.save()

    def __str__(self):
        return self.title

    
