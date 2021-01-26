class Error():
    def __init__(self,input_error):
        super().__init__()

        # setting title
        self.setWindowTitle(input_error)
        self.setStyleSheet("background-color: White;")
        self.width = 280
        self.setFixedWidth(self.width)
        self.height = 355
        self.setFixedHeight(self.height)

        self.center()
        # showing all the widgets
        self.show()

        # method for widgets