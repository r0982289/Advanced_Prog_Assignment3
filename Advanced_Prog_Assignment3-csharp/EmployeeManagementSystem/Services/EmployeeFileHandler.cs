using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using EmployeeManagementSystemCSharp.Models;

namespace EmployeeManagementSystemCSharp.Services
{
    /// <summary>
    /// reading and writing employee
    /// </summary>
    public class EmployeeFileHandler
    {
        private readonly List<Employee> _employees;
        private readonly string _fileName;
        private readonly bool _append;

        public EmployeeFileHandler(List<Employee> employees, string fileName, bool append)
        {
            _employees = employees;
            _fileName = fileName;
            _append = append;
        }

        public void Run()
        {
            if (_employees != null)
            {
                WriteEmployeesToFile();
            }
            else
            {
                ReadEmployeesFromFile();
            }
        }

        private void WriteEmployeesToFile()
        {
            try
            {
                using (StreamWriter writer = new StreamWriter(_fileName, _append))
                {
                    foreach (Employee emp in _employees)
                    {
                        string line =
                            emp.getEmployeeID() + "," +
                            emp.getFirstName() + "," +
                            emp.getLastName() + "," +
                            (emp.getPosition() != null ? emp.getPosition().getPositionName() : "") + "," +
                            emp.getDepartment() + "," +
                            emp.getPaid();

                        writer.WriteLine(line);
                    }
                }

                Console.WriteLine($"Finished writing employees to file: {_fileName}");
            }
            catch (IOException ex)
            {
                Console.Error.WriteLine("I/O error while writing file '" + _fileName + "': " + ex.Message);
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine("Unexpected error while writing file '" + _fileName + "': " + ex.Message);
            }
        }

        private void ReadEmployeesFromFile()
        {
            try
            {
                if (!File.Exists(_fileName))
                {
                    Console.Error.WriteLine("File not found: " + _fileName);
                    return;
                }

                Console.WriteLine($"Contents of file '{_fileName}':");

                using (StreamReader reader = new StreamReader(_fileName))
                {
                    string? line;
                    while ((line = reader.ReadLine()) != null)
                    {
                        Console.WriteLine(line);
                    }
                }
            }
            catch (IOException ex)
            {
                Console.Error.WriteLine("I/O error while reading file '" + _fileName + "': " + ex.Message);
            }
            catch (Exception ex)
            {
                Console.Error.WriteLine("Unexpected error while reading file '" + _fileName + "': " + ex.Message);
            }
        }
    }
}
