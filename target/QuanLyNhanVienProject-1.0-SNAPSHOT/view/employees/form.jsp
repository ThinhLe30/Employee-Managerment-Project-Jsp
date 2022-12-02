<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Department Manager</title>
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
          href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&family=Varela+Round&display=swap"
          rel="stylesheet"
  />
  <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
          integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"
  />
  <link
          rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
  />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="index.css" />
  <script src="main.js"></script>
</head>

<body>
<div class="container">
  <div class="side">
    <div class="title">
      <img src="./img/logo/office.png" alt="" />
      <p>Management</p>
    </div>
    <ul class="nav">
      <li class="nav-list">
        <i class="nav-icon fa-solid fa-users"></i>
        <p class="nav-text">Employee</p>
      </li>
      <li class="nav-list">
        <i class="nav-icon fa-solid fa-building-user"></i>
        <p class="nav-text">Department</p>
      </li>
      <li class="nav-list">
        <i class="nav-icon fa-solid fa-file-invoice-dollar"></i>
        <p class="nav-text">Salary Level</p>
      </li>
      <li class="nav-list">
        <i class="nav-icon fa-solid fa-user"></i>
        <p class="nav-text">Admin</p>
      </li>
    </ul>
    <div class="logout">
      <div class="btn-logout">
        <a href="#">
          Log out
          <i class="fa-solid fa-right-from-bracket"></i>
        </a>
      </div>
    </div>
  </div>
  <div class="table-responsive">
    <div class="table-wrapper">
      <div class="tabel-title">
        <p>Manage</p>
        <i class="fa-solid fa-circle"></i>
        <p class="text">Employee</p>
      </div>
      <div class="table-control">
        <div class="search">
          <input
                  type="search"
                  class="search-input"
                  id="search-input"
                  placeholder="Search"
                  autocomplete="off"
          />
          <i class="search-icon fa-solid fa-magnifying-glass"></i>
        </div>
        <div class="add">
          <a href="#addEmployeeModal" class="btn" data-toggle="modal">
            <div class="tooltip">
              <i class="add-icon fa-solid fa-plus"></i>
              <p class="tooltiptext">Add new employee</p>
            </div></a
          >
        </div>
      </div>
    </div>
    <table class="table table-striped table-hover table-borderless">
      <thead>
      <tr>
        <th>#</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Department</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>1</td>
        <td class="td-name">
          <img
                  src="/img/avatar/1.jpg"
                  class="avatar"
                  alt="Avatar"
          />Thomas Hardy
        </td>
        <td class="td-mail">thomashardy@mail.com</td>
        <td>(171) 555-2222</td>
        <td>89 Chiaroscuro Rd, Portland, USA</td>
        <td>Department A</td>
        <td class="td-action">
          <a href="#infoEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="info-icon fa-solid fa-circle-info"></i>
              <p class="tooltiptext">Info detail</p>
            </div></a
          >
          <a href="#editEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="edit-icon fa-solid fa-pen-to-square"></i>
              <p class="tooltiptext">Edit</p>
            </div></a
          >
          <a
                  href="#deleteEmployeeModal"
                  class="delete"
                  data-toggle="modal"
          >
            <div class="tooltip">
              <i class="delete-icon fa-solid fa-trash"></i>
              <p class="tooltiptext">Delete</p>
            </div>
          </a>
        </td>
      </tr>
      <tr>
        <td>2</td>
        <td class="td-name">
          <img
                  src="/img/avatar/2.jpg"
                  class="avatar"
                  alt="Avatar"
          />Dominique Perrier
        </td>
        <td class="td-mail">dominiqueperrier@mail.com</td>
        <td>(313) 555-5735</td>
        <td>Obere Str. 57, Berlin, Germany</td>
        <td>Department A</td>
        <td class="td-action">
          <a href="#infoEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="info-icon fa-solid fa-circle-info"></i>
              <p class="tooltiptext">Info detail</p>
            </div></a
          >
          <a href="#editEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="edit-icon fa-solid fa-pen-to-square"></i>
              <p class="tooltiptext">Edit</p>
            </div></a
          >
          <a
                  href="#deleteEmployeeModal"
                  class="delete"
                  data-toggle="modal"
          >
            <div class="tooltip">
              <i class="delete-icon fa-solid fa-trash"></i>
              <p class="tooltiptext">Delete</p>
            </div>
          </a>
        </td>
      </tr>
      <tr>
        <td>3</td>
        <td class="td-name">
          <img src="/img/avatar/3.jpg" class="avatar" alt="Avatar" />Maria
          Anders
        </td>
        <td class="td-mail">mariaanders@mail.com</td>
        <td>(503) 555-9931</td>
        <td>25, rue Lauriston, Paris, France</td>
        <td>Department C</td>
        <td class="td-action">
          <a href="#infoEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="info-icon fa-solid fa-circle-info"></i>
              <p class="tooltiptext">Info detail</p>
            </div></a
          >
          <a href="#editEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="edit-icon fa-solid fa-pen-to-square"></i>
              <p class="tooltiptext">Edit</p>
            </div></a
          >
          <a
                  href="#deleteEmployeeModal"
                  class="delete"
                  data-toggle="modal"
          >
            <div class="tooltip">
              <i class="delete-icon fa-solid fa-trash"></i>
              <p class="tooltiptext">Delete</p>
            </div>
          </a>
        </td>
      </tr>
      <tr>
        <td>4</td>
        <td class="td-name">
          <img src="/img/avatar/4.jpg" class="avatar" alt="Avatar" />Fran
          Wilson
        </td>
        <td class="td-mail">franwilson@mail.com</td>
        <td>(204) 619-5731</td>
        <td>C/ Araquil, 67, Madrid, Spain</td>
        <td>Department B</td>
        <td class="td-action">
          <a href="#infoEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="info-icon fa-solid fa-circle-info"></i>
              <p class="tooltiptext">Info detail</p>
            </div></a
          >
          <a href="#editEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="edit-icon fa-solid fa-pen-to-square"></i>
              <p class="tooltiptext">Edit</p>
            </div></a
          >
          <a
                  href="#deleteEmployeeModal"
                  class="delete"
                  data-toggle="modal"
          >
            <div class="tooltip">
              <i class="delete-icon fa-solid fa-trash"></i>
              <p class="tooltiptext">Delete</p>
            </div>
          </a>
        </td>
      </tr>
      <tr>
        <td>5</td>
        <td class="td-name">
          <img
                  src="/img/avatar/5.jpg"
                  class="avatar"
                  alt="Avatar"
          />Martin Blank
        </td>
        <td class="td-mail">martinblank@mail.com</td>
        <td>(480) 631-2097</td>
        <td>Via Monte Bianco 34, Turin, Italy</td>
        <td>Department C</td>
        <td class="td-action">
          <a href="#infoEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="info-icon fa-solid fa-circle-info"></i>
              <p class="tooltiptext">Info detail</p>
            </div></a
          >
          <a href="#editEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="edit-icon fa-solid fa-pen-to-square"></i>
              <p class="tooltiptext">Edit</p>
            </div></a
          >
          <a
                  href="#deleteEmployeeModal"
                  class="delete"
                  data-toggle="modal"
          >
            <div class="tooltip">
              <i class="delete-icon fa-solid fa-trash"></i>
              <p class="tooltiptext">Delete</p>
            </div>
          </a>
        </td>
      </tr>
      <tr>
        <td>6</td>
        <td class="td-name">
          <img
                  src="/img/avatar/5.jpg"
                  class="avatar"
                  alt="Avatar"
          />Martin Blank
        </td>
        <td class="td-mail">martinblank@mail.com</td>
        <td>(480) 631-2097</td>
        <td>Via Monte Bianco 34, Turin, Italy</td>
        <td>Department C</td>
        <td class="td-action">
          <a href="#infoEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="info-icon fa-solid fa-circle-info"></i>
              <p class="tooltiptext">Info detail</p>
            </div></a
          >
          <a href="#editEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="edit-icon fa-solid fa-pen-to-square"></i>
              <p class="tooltiptext">Edit</p>
            </div></a
          >
          <a
                  href="#deleteEmployeeModal"
                  class="delete"
                  data-toggle="modal"
          >
            <div class="tooltip">
              <i class="delete-icon fa-solid fa-trash"></i>
              <p class="tooltiptext">Delete</p>
            </div>
          </a>
        </td>
      </tr>
      <tr>
        <td>7</td>
        <td class="td-name">
          <img
                  src="/img/avatar/1.jpg"
                  class="avatar"
                  alt="Avatar"
          />Thomas Hardy
        </td>
        <td class="td-mail">thomashardy@mail.com</td>
        <td>(171) 555-2222</td>
        <td>89 Chiaroscuro Rd, Portland, USA</td>
        <td>Department A</td>
        <td class="td-action">
          <a href="#infoEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="info-icon fa-solid fa-circle-info"></i>
              <p class="tooltiptext">Info detail</p>
            </div></a
          >
          <a href="#editEmployeeModal" class="edit" data-toggle="modal">
            <div class="tooltip">
              <i class="edit-icon fa-solid fa-pen-to-square"></i>
              <p class="tooltiptext">Edit</p>
            </div></a
          >
          <a
                  href="#deleteEmployeeModal"
                  class="delete"
                  data-toggle="modal"
          >
            <div class="tooltip">
              <i class="delete-icon fa-solid fa-trash"></i>
              <p class="tooltiptext">Delete</p>
            </div>
          </a>
        </td>
      </tr>
      </tbody>
    </table>
    <ul class="pagination">
      <li class="page-item">
        <a href="#" class="page-control">
          <i class="fa-solid fa-arrow-left-long"></i
          ></a>
      </li>
      <li class="page-item"><a href="#" class="page-link">1</a></li>
      <li class="page-item"><a href="#" class="page-link">2</a></li>
      <li class="page-item active">
        <a href="#" class="page-link">3</a>
      </li>
      <li class="page-item"><a href="#" class="page-link">4</a></li>
      <li class="page-item"><a href="#" class="page-link">5</a></li>
      <li class="page-item">
        <a href="#" class="page-control"
        ><i class="fa-solid fa-arrow-right-long"></i
        ></a>
      </li>
    </ul>
  </div>
</div>
<!-- Add Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form>
        <div class="modal-header">
          <h4 class="modal-title">Add Employee</h4>
          <button
                  type="button"
                  class="close"
                  data-dismiss="modal"
                  aria-hidden="true"
          >
            &times;
          </button>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label>First Name</label>
            <input type="text" class="form-control" required />
          </div>
          <div class="form-group">
            <label>Last Name</label>
            <input type="text" class="form-control" required />
          </div>
          <div class="form-group">
            <label>Image</label>
            <input
                    type="file"
                    id="upload"
                    onChange="handleImageUpload()"
                    required
            />
          </div>
          <div class="form-group">
            <label></label>
            <img
                    src="/img/avatar/default.jpg"
                    class="avatar"
                    alt="Avatar"
                    id="display-avatar"
            />
          </div>
          <div class="form-group">
            <label>Email</label>
            <input type="email" class="form-control" required />
          </div>
          <div class="form-group">
            <label>Birthday</label>
            <input
                    type="date"
                    max="9999-12-31"
                    class="form-control"
                    required
            />
          </div>
          <div class="form-group">
            <label>Address</label>
            <textarea class="form-control" required></textarea>
          </div>
          <div class="form-group gender-group">
            <label>Gender</label>
            <div class="form-control gender">
              <div>
                <input type="radio" id="male" name="gender" value="Male" />
                <label for="male">Male</label>
              </div>
              <div>
                <input
                        type="radio"
                        id="female"
                        name="gender"
                        value="Female"
                />
                <label for="female">Female</label>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label>Phone</label>
            <input type="text" class="form-control" required />
          </div>
          <div class="form-group">
            <label for="department">Department</label>
            <select class="form-control" id="department">
              <option value="">--Please choose an option--</option>
              <option value="dog">Dog</option>
              <option value="cat">Cat</option>
              <option value="hamster">Hamster</option>
              <option value="parrot">Parrot</option>
              <option value="spider">Spider</option>
              <option value="goldfish">Goldfish</option>
            </select>
          </div>
          <div class="form-group">
            <label for="position">Position</label>
            <select class="form-control" id="position">
              <option value="">--Please choose an option--</option>
              <option value="dog">Dog</option>
              <option value="cat">Cat</option>
              <option value="hamster">Hamster</option>
              <option value="parrot">Parrot</option>
              <option value="spider">Spider</option>
              <option value="goldfish">Goldfish</option>
            </select>
          </div>
          <div class="form-group">
            <label for="salary">Salary</label>
            <select class="form-control" id="salary">
              <option value="">--Please choose an option--</option>
              <option value="dog">Dog</option>
              <option value="cat">Cat</option>
              <option value="hamster">Hamster</option>
              <option value="parrot">Parrot</option>
              <option value="spider">Spider</option>
              <option value="goldfish">Goldfish</option>
            </select>
          </div>
        </div>
        <div class="modal-footer">
          <input
                  type="button"
                  class="btn btn-default"
                  data-dismiss="modal"
                  value="Cancel"
          />
          <input type="submit" class="btn btn-add" value="Add" />
        </div>
      </form>
    </div>
  </div>
</div>
<!-- Info Modal HTML -->
<div id="infoEmployeeModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form>
        <div class="modal-header">
          <h4 class="modal-title">Infomation Of Employee</h4>
          <button
                  type="button"
                  class="close"
                  data-dismiss="modal"
                  aria-hidden="true"
          >
            &times;
          </button>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label></label>
            <img src="/img/avatar/1.jpg" class="avatar" alt="Avatar" />
          </div>
          <div class="form-group">
            <label>Name: </label>
            Thomas Hardy
          </div>
          <div class="form-group">
            <label>Email:</label>
            thomashardy@mail.com
          </div>
          <div class="form-group">
            <label>Birthday: </label>
            04/07/2002
          </div>
          <div class="form-group">
            <label>Address: </label>
            89 Chiaroscuro Rd, Portland, USA
          </div>
          <div class="form-group">
            <label>Gender: </label>
            Male
          </div>
          <div class="form-group">
            <label>Phone: </label>
            (171) 555-2222
          </div>
          <div class="form-group">
            <label for="department">Department: </label>
            Department A
          </div>
          <div class="form-group">
            <label for="position">Position</label>
            CEO
          </div>
          <div class="form-group">
            <label for="salary">Salary</label>
            1500$
          </div>
        </div>
        <div class="modal-footer">
          <input
                  type="button"
                  class="btn btn-default"
                  data-dismiss="modal"
                  value="Cancel"
          />
        </div>
      </form>
    </div>
  </div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form>
        <div class="modal-header">
          <h4 class="modal-title">Edit Employee</h4>
          <button
                  type="button"
                  class="close"
                  data-dismiss="modal"
                  aria-hidden="true"
          >
            &times;
          </button>
        </div>
        <div class="modal-body">
          <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" required />
          </div>
          <div class="form-group">
            <label>Last Name</label>
            <input type="text" class="form-control" required />
          </div>
          <div class="form-group">
            <label>Image</label>
            <input
                    type="file"
                    id="upload"
                    onChange="handleImageUpload()"
                    required
            />
          </div>
          <div class="form-group">
            <label></label>
            <img
                    src="/img/avatar/default.jpg"
                    class="avatar"
                    alt="Avatar"
                    id="display-avatar"
            />
          </div>
          <div class="form-group">
            <label>Email</label>
            <input type="email" class="form-control" required />
          </div>
          <div class="form-group">
            <label>Birthday</label>
            <input
                    type="date"
                    max="9999-12-31"
                    class="form-control"
                    required
            />
          </div>
          <div class="form-group">
            <label>Address</label>
            <textarea class="form-control" required></textarea>
          </div>
          <div class="form-group gender-group">
            <label>Gender</label>
            <div class="form-control gender">
              <div>
                <input type="radio" id="man" name="gender" value="Man" />
                <label for="man">Man</label>
              </div>
              <div>
                <input
                        type="radio"
                        id="woman"
                        name="gender"
                        value="Woman"
                />
                <label for="woman">Woman</label>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label>Phone</label>
            <input type="text" class="form-control" required />
          </div>
          <div class="form-group">
            <label for="department">Department</label>
            <select class="form-control" id="department">
              <option value="">--Please choose an option--</option>
              <option value="dog">Dog</option>
              <option value="cat">Cat</option>
              <option value="hamster">Hamster</option>
              <option value="parrot">Parrot</option>
              <option value="spider">Spider</option>
              <option value="goldfish">Goldfish</option>
            </select>
          </div>
          <div class="form-group">
            <label for="position">Position</label>
            <select class="form-control" id="position">
              <option value="">--Please choose an option--</option>
              <option value="dog">Dog</option>
              <option value="cat">Cat</option>
              <option value="hamster">Hamster</option>
              <option value="parrot">Parrot</option>
              <option value="spider">Spider</option>
              <option value="goldfish">Goldfish</option>
            </select>
          </div>
          <div class="form-group">
            <label for="salary">Salary</label>
            <select class="form-control" id="salary">
              <option value="">--Please choose an option--</option>
              <option value="dog">Dog</option>
              <option value="cat">Cat</option>
              <option value="hamster">Hamster</option>
              <option value="parrot">Parrot</option>
              <option value="spider">Spider</option>
              <option value="goldfish">Goldfish</option>
            </select>
          </div>
        </div>
    </div>
    <div class="modal-footer">
      <input
              type="button"
              class="btn btn-default"
              data-dismiss="modal"
              value="Cancel"
      />
      <input type="submit" class="btn btn-save" value="Save" />
    </div>
    </form>
  </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form>
        <div class="modal-header">
          <h4 class="modal-title">Delete Employee</h4>
          <button
                  type="button"
                  class="close"
                  data-dismiss="modal"
                  aria-hidden="true"
          >
            &times;
          </button>
        </div>
        <div class="modal-body">
          <p>Are you sure you want to delete this employee?</p>
          <p class="text-warning">
            <small>This action cannot be undone.</small>
          </p>
        </div>
        <div class="modal-footer">
          <input
                  type="button"
                  class="btn btn-default"
                  data-dismiss="modal"
                  value="Cancel"
          />
          <input type="submit" class="btn btn-danger" value="Delete" />
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
