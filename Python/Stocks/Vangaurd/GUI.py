# importing libraries
from PyQt5.QtWidgets import *
from PyQt5.QtGui import *
from PyQt5.QtGui import QPixmap
from PyQt5 import QtCore
import sys

class Window(QMainWindow):
    def __init__(self):
        super().__init__()

        # setting title
        self.setWindowTitle(" Vanguard Investment GUI Login ")
        self.setStyleSheet("background-color: White;")
        self.width = 280
        self.setFixedWidth(self.width)
        self.height = 355
        self.setFixedHeight(self.height)

        # calling method
        self.UiComponents()

        # showing all the widgets
        self.show()

        # method for widgets
    def center(self):
        qr = self.frameGeometry()
        cp = QDesktopWidget().availableGeometry().center()
        qr.moveCenter(cp)
        self.move(qr.topLeft())

    def UiComponents(self):

        # Sets Vanguard pic
        label_pic = QLabel(self)
        pixmap = QPixmap('Vanguard.png')
        label_pic.setPixmap(pixmap)
        label_pic.resize(pixmap.width(), pixmap.height())
        label_pic.setAlignment(QtCore.Qt.AlignCenter)
        label_pic.setStyleSheet("border :2px padding:15")

        # Username and Password inputs.

        line_user = QLineEdit("Username",self)
        line_user.setPlaceholderText(self)
        line_user.setStyleSheet("font-size: 16px")
        line_user.setGeometry(5,250,self.width-10,45)

        line_pass = QLineEdit("Password", self)
        line_pass.setStyleSheet("font-size: 16px")
        line_pass.setGeometry(5,300,self.width-10,45)

        #Adds Login Button
        widget = QWidget()
        button_login = QPushButton('Login',self)
        button_login.setGeometry(5,200,self.width-10,45)
        button_login.setStyleSheet("background: #c41235; color: white;font-family: Broadway; font-size:24px")


       # opening window in maximized size
        self.center()
