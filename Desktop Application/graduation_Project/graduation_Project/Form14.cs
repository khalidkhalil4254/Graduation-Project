using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace graduation_Project
{
    public partial class Form14 : Form
    {
        public Form14()
        {
            InitializeComponent();
        }

        private void dateTimePicker1_ValueChanged(object sender, EventArgs e)
        {

        }

        private void Form14_Load(object sender, EventArgs e)
        {
            StartingPicker_SessionsForm.Format = DateTimePickerFormat.Custom;
            StartingPicker_SessionsForm.CustomFormat = "MM/dd/yyyy hh:mm:ss";
           EndingPicker_SessionsForm.Format = DateTimePickerFormat.Custom;
           EndingPicker_SessionsForm.CustomFormat = "MM/dd/yyyy hh:mm:ss";
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Form1 f1 = new Form1();
            f1.Show();
            this.Close();
        }
    }
}
