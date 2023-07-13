using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net.Http;
using Newtonsoft.Json;

namespace graduation_Project
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form1 f1=new Form1();
            f1.Show();
            this.Close();
        }

        private void label2_Click(object sender, EventArgs e)
        {
            
            Form5 form5 = new Form5();
            form5.Show();
        }

        private async void button1_Click(object sender, EventArgs e)
        {

            Console.WriteLine("this is our work.... do you see it?");

            try
            {

                string username = username_txt_login.Text;
                string password = password_txt_login.Text;

                using (var client = new HttpClient())
                {
                    var data = new { USERNAME = username, PASSWORD = password };
                    var json = Newtonsoft.Json.JsonConvert.SerializeObject(data);
                    var content = new StringContent(json, Encoding.UTF8, "application/json");

                    var request = new HttpRequestMessage(HttpMethod.Get, "https://o6iz3yjg55.execute-api.us-east-1.amazonaws.com/api/v0/auth/read");
                    request.Content = content;

                    var response = await client.SendAsync(request);
                    var result = await response.Content.ReadAsStringAsync();

                    if (result != "" || result != null)
                    {
                       
                    
                    }
                    else {
                        MessageBox.Show("User Not Found!");
                    }


                    Console.WriteLine($"Reponse: {result}");
                }
            }
            catch (Exception er)
            {
                Console.WriteLine(er.ToString());
            }



            /*            string username = username_txt_login.Text;
                        string password = password_txt_login.Text;


                        var client = new HttpClient();
                            var data = new { USERNAME = username, PASSWORD = password };
                            var json = Newtonsoft.Json.JsonConvert.SerializeObject(data);
                            var content = new StringContent(json, Encoding.UTF8, "application/json");
                            var request = new HttpRequestMessage(HttpMethod.Get, "https://o6iz3yjg55.execute-api.us-east-1.amazonaws.com/api/v0/auth/read");
                            request.Content = content;
                            var response = await client.SendAsync(request);
                            var result = await response.Content.ReadAsStringAsync();
                            Console.WriteLine($"Results: {result}");

                        if (result != "" || result != null)
                        {
                            Form1 form = new Form1();
                            form.Show();
                            this.Visible = false; //opened in the background but invisible
                        }
                        else {
                            Console.WriteLine("User Not Found!");
                        }*/


        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form2_Load(object sender, EventArgs e)
        {
            
  
        }
    }
}
