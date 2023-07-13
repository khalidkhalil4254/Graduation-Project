namespace graduation_Project
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label12_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            Form4 f4 = new Form4();
            f4.Show();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            Form3 f3 = new Form3();
            f3.Show();
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            Form14 f14 = new Form14();
            f14.Show();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void EmailToPicBox_AdminPannel_Click(object sender, EventArgs e)
        {

        }

        private void EmailPicBox_AdminPannel_Click(object sender, EventArgs e)
        {
            Form6 f6 = new Form6();
            f6.Show();
            this.Close();
        }

        private void LogoutPicBox_AdminPannel_Click(object sender, EventArgs e)
        {
            Form2 f2=new Form2();
            f2.Show();
            this.Close();
        }
    }
}