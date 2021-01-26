# importing libraries
from PyQt5.QtWidgets import *
from PyQt5.QtGui import *
from PyQt5.QtGui import QPixmap
from PyQt5 import QtCore
import sys

class Window2(QMainWindow):
    def __init__(self):
        super().__init__()

        # setting title
        self.setWindowTitle(" Vanguard Investment GUI ")
        self.setStyleSheet("background-color: White;")
        # calling method
        self.UiComponents()

        # showing all the widgets
        self.show()

        # method for widgets

    def UiComponents(self):
        # setting Username label
        label_user = QLabel("Username", self)
        label_user.setGeometry(0,200 ,0, 35)
        label_user.setStyleSheet("border : 2px solid black")
        label_user.setAlignment(QtCore.Qt.AlignCenter)

        # creating password Label
        label_pass = QLabel("Password", self)
        label_pass.setGeometry(0, 100, 0, 35)
        label_pass.setStyleSheet("border : 2px solid black")
        label_pass.setAlignment(QtCore.Qt.AlignCenter)

        #Adds Login Button
        widget = QWidget()
        button_login = QPushButton(widget)
        button_login.setText("Login")
        #button_login.setAlignment(QtCore.Qt.AlignCenter)
        # opening window in maximized size
        self.showMaximized()
